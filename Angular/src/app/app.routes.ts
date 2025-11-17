import { Routes } from '@angular/router';
import { LivreAll } from './page/livre/livre-all/livre-all';
import { AuteurAll } from './page/auteur/auteur-all/auteur-all';
//import { CollectionAll } from './page/collection/collection-all/collection-all';
import { EditeurAll } from './page/editeur/editeur-all/editeur-all';

export const routes: Routes = [
    { path: 'livre', component: LivreAll },
    { path: 'auteur', component: AuteurAll},
    //{ path: 'collection', component: CollectionAll},
    { path: 'editeur', component: EditeurAll},
];

