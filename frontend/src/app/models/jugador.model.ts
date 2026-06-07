export interface Jugador{
    id: number;
    nombre: string;
    dorsal: number;
    posicion: string;
    edad: number;
    goles: number;
    asistencias: number;
    equipo: { id: number; pais: string; escudoURL: string };
}