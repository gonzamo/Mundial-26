import { Jugador } from './jugador.model';

export interface Equipo{
    id: number;
    pais: string;
    entrenador: string;
    escudoURL: string;
    grupo: {id: number; letra:string;};
    jugadores?: Jugador[];
}