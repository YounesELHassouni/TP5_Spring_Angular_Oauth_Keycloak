import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  public products:any;
  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(){
    this.httpClient.get('http://localhost:8087/api/products').subscribe({
      next: data => {
        this.products= data;
      },
      error: error => {
        console.log('There was an error!', error);
      }
    });
  }

}
