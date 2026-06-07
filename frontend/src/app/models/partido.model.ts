import { Equipo } from "./equipo.model";

export interface Partido {
  id: number;
  equipoLocal: Equipo;
  equipoVisitante: Equipo;
  golesLocal: number;
  golesVisitante: number;
  fecha: string;
  estado: string;
  fase: string;
  estadio: { nombre: string; ciudad: string };
}