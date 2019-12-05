import { Usuario } from './usuario';
import { ConfiguracaoAgenda } from './configuracao-agenda';

export class Tatuador {
    constructor(
        public id: number,
        public usuario: Usuario,
        public telefone1: string,
        public telefone2: string,
        public alvara: string,
        public configuracaoAgenda: ConfiguracaoAgenda[]
        //public posts: Post[],
        //public endereco: Endereco,
        
    ){}
}
