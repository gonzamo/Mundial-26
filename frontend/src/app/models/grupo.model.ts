import { Equipo } from "./equipo.model";

export interface Grupo{
    id: number;
    letra: string;
    equipos: Equipo[];
}