import { Time } from '@angular/common';
import { ConfiguracaoAgenda } from './configuracao-agenda';
import { Cliente } from './cliente';

export class HorarioAgendado {
    constructor(
        public id: number,
        public horario: Time,
        public configuracaoAgenda: ConfiguracaoAgenda,
        public cliente: Cliente
    ){}
}
