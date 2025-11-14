import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuteurDto } from './auteur-dto';

describe('AuteurDto', () => {
  let component: AuteurDto;
  let fixture: ComponentFixture<AuteurDto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AuteurDto]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AuteurDto);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
