import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaintenanceService {
  private baseUrl = 'http://localhost:8081/api/v1/maintenance-bills'; 

  constructor(private http: HttpClient) { }

  getBills(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  addBills(bills: any[]): Observable<any> {
    return this.http.post(this.baseUrl, bills);
  }

  deleteBill(billId: number): Observable<any> {
    const url = `${this.baseUrl}/${billId}`;
    return this.http.delete(url);
  }
}

