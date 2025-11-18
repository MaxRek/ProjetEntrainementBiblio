export class AuthRequestDto {
    constructor(private _login: string, private _mdp: string) { }

    public get login(): string {
        return this._login;
    }

    public set login(value: string) {
        this._login = value;
    }

    public get mdp(): string {
        return this._mdp;
    }

    public set mdp(value: string) {
        this._mdp = value;
    }

    public toJson(): any {
        return {
            login: this.login,
            mdp: this.mdp
        };
    }
}
