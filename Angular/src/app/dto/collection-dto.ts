export class CollectionDto {
    constructor(private _id:number, private _nom:string){}

   public get id () : number {
        return this._id;
    }

    public set id (id : number) {
        this._id=id;
    }

    public get nom () : string {
        return this._nom;
    }

    public set nom (nom : string) {
        this._nom=nom;
    }

     public toJson(): any {
        return {
            nom: this._nom,
            id : this._id
        };
    }
}
