import { TestBed } from '@angular/core/testing';

import { HorarioAgendadoService } from './horario-agendado.service';

describe('HorarioAgendadoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HorarioAgendadoService = TestBed.get(HorarioAgendadoService);
    expect(service).toBeTruthy();
  });
});
