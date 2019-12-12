export class Usuario {
    constructor(
        public id: number,
        public login: string,
        public nome: string,
        public cpf: string,
        public email: string,
        public ativo: boolean,
    ){}
}
