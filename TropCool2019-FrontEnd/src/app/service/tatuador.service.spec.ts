import { TestBed } from '@angular/core/testing';

import { TatuadorService } from './tatuador.service';

describe('TatuadorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TatuadorService = TestBed.get(TatuadorService);
    expect(service).toBeTruthy();
  });
});
