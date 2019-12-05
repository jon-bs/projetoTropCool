import { Time } from '@angular/common';
import { Tatuador } from './tatuador';
import { HorarioAgendado } from './horario-agendado';
import { DiaSemana } from './dia-da-semana';

export class ConfiguracaoAgenda {
    constructor(
        public id: number,
        public horaInicio: Time,
        public horaTermino: Time,
        public tatuador: Tatuador,
        public horariosAgendados: HorarioAgendado[],
        public diaSemana: DiaSemana
    ){}
}
