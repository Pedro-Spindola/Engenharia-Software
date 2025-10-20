import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuncionarioAcao } from './funcionario-acao';

describe('FuncionarioAcao', () => {
  let component: FuncionarioAcao;
  let fixture: ComponentFixture<FuncionarioAcao>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FuncionarioAcao]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FuncionarioAcao);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
