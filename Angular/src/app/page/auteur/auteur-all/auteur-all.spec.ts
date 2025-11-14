import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuteurAll } from './auteur-all';

describe('AuteurAll', () => {
  let component: AuteurAll;
  let fixture: ComponentFixture<AuteurAll>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AuteurAll]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AuteurAll);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
