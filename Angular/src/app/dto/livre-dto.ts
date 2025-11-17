export class LivreDto {

    constructor(
    private _id:number,
	private _titre:string,
    private _resumer:string,
    private _annee:string,
    private _auteur: any,
    private _editeur: any,
    private _collection?: any
    ) {}
	
public get id(): number {
    return this._id;
}

public set id(value: number) {
    this._id = value;
}

public get titre(): string {
    return this._titre;
}

public set titre(value: string) {
    this._titre = value;
}

public get resumer(): string {
    return this._resumer;
}

public set resumer(value: string) {
    this._resumer = value;
}

public get annee(): string {
    return this._annee;
}

public set annee(value: string) {
    this._annee = value;
}

    public get auteur(): any {
        return this._auteur;
    }

    public set auteur(value: any) {
        this._auteur = value;
    }

    public get editeur(): any {
        return this._editeur;
    }

    public set editeur(value: any) {
        this._editeur = value;
    }

    public get collection(): any | undefined {
        return this._collection;
    }

    public set collection(value: any | undefined) {
        this._collection = value;
    }


    public toJson(): any {
        return {
            id: this._id ?? null,
            titre: this._titre,
            resumer: this._resumer,
            annee: this._annee,
            auteur: this._auteur,
            editeur: this._editeur,
            collection: this._collection ?? null
        };
    }
}
