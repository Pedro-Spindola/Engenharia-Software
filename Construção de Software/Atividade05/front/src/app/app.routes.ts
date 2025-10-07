import { Routes } from '@angular/router';
import { Home } from './component/home/home';
import { Sobre } from './component/sobre/sobre';
import { Contato } from './component/contato/contato';


export const routes: Routes = [
    { path: '', component: Home},
    { path: 'sobre', component: Sobre},
    { path: 'contato', component: Contato}
];
