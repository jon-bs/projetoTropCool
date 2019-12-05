import { TestBed } from '@angular/core/testing';

import { ConfiguracaoAgendaService } from './configuracao-agenda.service';

describe('ConfiguracaoAgendaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ConfiguracaoAgendaService = TestBed.get(ConfiguracaoAgendaService);
    expect(service).toBeTruthy();
  });
});
