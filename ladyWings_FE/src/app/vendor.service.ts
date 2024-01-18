import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VendorService {

  private baseUrl = 'http://localhost:8081/api/v1/vendor'; // Update with your backend URL

  constructor(private http: HttpClient) {}

  getVendors(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }

  addVendor(vendor: any[]): Observable<any> {
    return this.http.post(`${this.baseUrl+"/vendors"}`, vendor);
  }
  deleteVendor(vendorId: number): Observable<any> {
    const url = `${this.baseUrl}/${vendorId}`;
    return this.http.delete(url);
  }
}
