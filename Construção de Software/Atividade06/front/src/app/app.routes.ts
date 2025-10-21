import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Lista } from './components/lista/lista';
import { EditarFuncionario } from './components/editar-funcionario/editar-funcionario';
import { CadastrarFuncionario } from './components/cadastrar-funcionario/cadastrar-funcionario';

export const routes: Routes = [
    { path: '', component: Home},
    { path: 'lista', component: Lista},
    { path: 'cadastro', component: CadastrarFuncionario},
    { path: 'funcionario/editar/:id', component: EditarFuncionario }
];
