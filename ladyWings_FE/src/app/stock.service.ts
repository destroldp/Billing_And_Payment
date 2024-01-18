import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  private baseUrl = 'http://localhost:8081/api/v1/stock'; // Update with your Spring Boot backend URL

  constructor(private http: HttpClient) { }

  addStock(stock: any[]): Observable<any> {
    return this.http.post(this.baseUrl+"/stockin", stock);
  }

  getStock(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }

  getStockByID(stocktId: number): Observable<any> {
    const url = `${this.baseUrl}/${stocktId}`;
    return this.http.get(url);
  }

  updateStockById(stock: any,stocktId: number): Observable<any> {
    return this.http.put(this.baseUrl+"/"+stocktId, stock);
  }
  
}
