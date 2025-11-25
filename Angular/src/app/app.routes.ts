import { Routes } from '@angular/router';
import { LivreAll } from './page/livre/livre-all/livre-all';
import { AuteurAll } from './page/auteur/auteur-all/auteur-all';
import { Collection } from './page/collection/collection';
import { EditeurAll } from './page/editeur/editeur-all/editeur-all';
import { LoginPage } from './page/login-page/login-page';
import { authGuard } from './guard/auth-guard';

export const routes: Routes = [
    { path: 'livre', component: LivreAll },
    { path: 'auteur', component: AuteurAll},
    { path: 'collection', component: Collection},
    { path: 'editeur', component: EditeurAll},
    { path: 'login', component: LoginPage }

];

