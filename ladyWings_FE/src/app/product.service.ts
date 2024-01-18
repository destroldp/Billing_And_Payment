// product.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = 'http://localhost:8081/api/v1/product'; // Update with your Spring Boot backend URL

  constructor(private http: HttpClient) { }

  addProduct(product: any[]): Observable<any> {
    return this.http.post(this.baseUrl+"/productId", product);
  }

  getProducts(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }
  deleteProduct(productId: number): Observable<any> {
    const url = `${this.baseUrl}/${productId}`;
    return this.http.delete(url);
  }
}
