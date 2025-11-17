import { AuteurDto } from "./auteur-dto";
import { CollectionDto } from "./collection-dto";
import { EditeurDto } from "./editeur-dto";

export class LivreDto {

    constructor(
    private _id:number,
	private _titre:string,
    private _resumer:string,
    private _annee:string,
    private _auteur: AuteurDto | null,
    private _editeur: EditeurDto | null,
    private _collection?: CollectionDto | null
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

public get auteur(): AuteurDto | null {
    return this._auteur;
  }
  public set auteur(value: AuteurDto | null) {
    this._auteur = value;
  }

  public get editeur(): EditeurDto | null {
    return this._editeur;
  }
  public set editeur(value: EditeurDto | null) {
    this._editeur = value;
  }

  public get collection(): CollectionDto | null | undefined {
    return this._collection;
  }
  public set collection(value: CollectionDto | null | undefined) {
    this._collection = value;
  }

  public toJson(): any {
    return {
      titre: this._titre,
      resumer: this._resumer,
      annee: this._annee,
      auteur: this._auteur ? { id: this._auteur.id } : null,
      editeur: this._editeur ? { id: this._editeur.id } : null,
      collection: this._collection ? { id: this._collection.id } : null
    };
  }
}
