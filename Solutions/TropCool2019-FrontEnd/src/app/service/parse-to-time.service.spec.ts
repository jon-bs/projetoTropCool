import { TestBed } from '@angular/core/testing';

import { ParseToTimeService } from './parse-to-time.service';

describe('ParseToTimeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ParseToTimeService = TestBed.get(ParseToTimeService);
    expect(service).toBeTruthy();
  });
});
