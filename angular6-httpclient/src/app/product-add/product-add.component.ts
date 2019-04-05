import { Component, OnInit, Input } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  @Input() productData = { name:'', price: 0, category: { id: 0 } };

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  addProduct() {
    this.rest.addProduct(this.productData).subscribe((result) => {
      this.router.navigate(['/products']);
    }, (err) => {
      console.log(err);
    });
  }

}
