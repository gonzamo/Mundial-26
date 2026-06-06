package com.mundial2026.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mundial2026.model.entity.Equipo;
import com.mundial2026.model.entity.Estadio;
import com.mundial2026.model.entity.Grupo;
import com.mundial2026.model.entity.Jugador;
import com.mundial2026.model.entity.Partido;
import com.mundial2026.model.enums.EstadoPartido;
import com.mundial2026.model.enums.FasePartido;
import com.mundial2026.model.enums.PosicionJugador;
import com.mundial2026.repository.EquipoRepository;
import com.mundial2026.repository.EstadioRepository;
import com.mundial2026.repository.GrupoRepository;
import com.mundial2026.repository.JugadorRepository;
import com.mundial2026.repository.PartidoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final GrupoRepository grupoRepository;
    private final EquipoRepository equipoRepository;
    private final EstadioRepository estadioRepository;
    private final JugadorRepository jugadorRepository;
    private final PartidoRepository partidoRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {

        // Solo carga si la base de datos está vacía
        if (grupoRepository.count() > 0) {
            log.info("La base de datos ya tiene datos, omitiendo carga inicial.");
            return;
        }

        log.info("Cargando datos del Mundial 2026...");
        cargarGruposYEquipos();
        cargarEstadios();
        cargarJugadores();
        cargarPartidos();
        log.info("¡Datos cargados correctamente!");
    }

    private void cargarGruposYEquipos() throws Exception {
        InputStream is = getClass().getResourceAsStream("/datos-mundial26.json");
        JsonNode root = objectMapper.readTree(is);
        JsonNode grupos = root.get("grupos");

        for (JsonNode grupoNode : grupos) {
            Grupo grupo = new Grupo();
            grupo.setLetra(grupoNode.get("letra").asText());
            grupoRepository.save(grupo);

            for (JsonNode equipoNode : grupoNode.get("equipos")) {
                Equipo equipo = new Equipo();
                equipo.setPais(equipoNode.get("pais").asText());
                equipo.setEntrenador(equipoNode.get("entrenador").asText());
                equipo.setEscudoURL(equipoNode.get("escudoUrl").asText());
                equipo.setGrupo(grupo);
                equipoRepository.save(equipo);
            }
        }
        log.info("Grupos y equipos cargados.");
    }

    private void cargarEstadios() throws Exception {
        InputStream is = getClass().getResourceAsStream("/datos-mundial26.json");
        JsonNode root = objectMapper.readTree(is);
        JsonNode estadios = root.get("estadios");

        for (JsonNode estadioNode : estadios) {
            Estadio estadio = new Estadio();
            estadio.setNombre(estadioNode.get("nombre").asText());
            estadio.setCiudad(estadioNode.get("ciudad").asText());
            estadio.setPais(estadioNode.get("pais").asText());
            estadio.setCapacidad(estadioNode.get("capacidad").asInt());
            estadioRepository.save(estadio);
        }
        log.info("Estadios cargados.");
    }

    private void cargarJugadores() throws Exception {
        InputStream is = getClass().getResourceAsStream("/jugadores-mundial26.json");
        JsonNode root = objectMapper.readTree(is);
        JsonNode selecciones = root.get("selecciones");

        for (JsonNode seleccionNode : selecciones) {
            String nombreEquipo = seleccionNode.get("equipo").asText();
            Equipo equipo = equipoRepository.findByPais(nombreEquipo).orElse(null);

            if (equipo == null) {
                log.warn("Equipo no encontrado: {}", nombreEquipo);
                continue;
            }

            for (JsonNode jugadorNode : seleccionNode.get("jugadores")) {
                Jugador jugador = new Jugador();
                jugador.setNombre(jugadorNode.get("nombre").asText());
                jugador.setDorsal(jugadorNode.get("dorsal").asInt());
                jugador.setEdad(jugadorNode.get("edad").asInt());
                jugador.setPosicion(PosicionJugador.valueOf(jugadorNode.get("posicion").asText()));
                jugador.setGoles(0);
                jugador.setAsistencias(0);
                jugador.setEquipo(equipo);
                jugadorRepository.save(jugador);
            }
        }
        log.info("Jugadores cargados.");
    }

    private void cargarPartidos() throws Exception {
    InputStream is = getClass().getClassLoader().getResourceAsStream("partidos-mundial26.json");
    JsonNode root = objectMapper.readTree(is);
    JsonNode partidos = root.get("partidos");

    for (JsonNode partidoNode : partidos) {
        String paisLocal = partidoNode.get("equipoLocal").asText();
        String paisVisitante = partidoNode.get("equipoVisitante").asText();
        String nombreEstadio = partidoNode.get("estadio").asText();

        Equipo equipoLocal = equipoRepository.findByPais(paisLocal).orElse(null);
        Equipo equipoVisitante = equipoRepository.findByPais(paisVisitante).orElse(null);
        Estadio estadio = estadioRepository.findByNombre(nombreEstadio).orElse(null);

        if (equipoLocal == null || equipoVisitante == null) {
            log.warn("Equipo no encontrado: {} vs {}", paisLocal, paisVisitante);
            continue;
        }

        Partido partido = new Partido();
        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);
        partido.setEstadio(estadio);
        partido.setFecha(LocalDateTime.parse(partidoNode.get("fecha").asText()));
        partido.setFase(FasePartido.GRUPOS);
        partido.setEstado(EstadoPartido.PROGRAMADO);
        partido.setGolesLocal(0);
        partido.setGolesVisitante(0);
        partidoRepository.save(partido);
    }
    log.info("Partidos cargados.");
}
}