import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditeurAll } from './editeur-all';

describe('EditeurAll', () => {
  let component: EditeurAll;
  let fixture: ComponentFixture<EditeurAll>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditeurAll]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditeurAll);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
