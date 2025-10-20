import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { FuncionarioAcao } from './components/funcionario-acao/funcionario-acao';

export const routes: Routes = [
    { path: '', component: Home},
    { path: 'funcionario/editar/:id', component: FuncionarioAcao }
];
