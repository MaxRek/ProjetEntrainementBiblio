import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LivreAll } from './livre-all';

describe('LivreAll', () => {
  let component: LivreAll;
  let fixture: ComponentFixture<LivreAll>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LivreAll]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LivreAll);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
