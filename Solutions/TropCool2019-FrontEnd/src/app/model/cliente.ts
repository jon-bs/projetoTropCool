import { Usuario } from './usuario';
import { HorarioAgendado } from './horario-agendado';

export class Cliente {
    constructor(
        public id: number,
        public usuario: Usuario,
        public telefone: string,
        public horarioAgendado: HorarioAgendado[]
    ){}
}
