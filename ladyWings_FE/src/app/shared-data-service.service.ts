import { Injectable } from '@angular/core';
import { Product } from '../app/customobjects/Product';
import { Vendor } from '../app/customobjects/Vendor';
import { Stock } from '../app/customobjects/Stock';
import { MaintenanceBill } from './customobjects/MaintenanceBill';

@Injectable({
  providedIn: 'root'
})
export class SharedDataServiceService {
  getDefaultProduct(): Product {
    return {
      productName: '',
      productDescription: '',
      id: '',
    };
  }

  getDefaultVendor(): Vendor {
    return {
    vendorName: '',
    vendorCompany: '',
    vendorId: '', 
    vendorAddress: {
      addressLine1: '',
      addressLine2: '',
      city: '',
      state: '',
      country: '',
      pincode: '',
    },
    vendorContactDetails: {
      contactDetailsId: null,
      phoneNumber: '',
      email: '',
    }
  
  }
};

getDefaultStock(): Stock{
  return {
      id: 0,
      productId: this.getDefaultProduct(),
      costPrice: 0,
      salePrice: 0,
      previousSoldPrice:0,
      quantity: 0,
      totalSale:0,
      productTotal: 0,
      vendorDetails: this.getDefaultVendor(),
      productName: '',
      remainingQuantity: 0,
      softDelete : ''
  }

}

getDefaultBills(): MaintenanceBill{
  return {
    id:0,
    description: '',
    BillTypes:'string',
    amount: 0,
    billingDate: new Date
  }

}
  constructor() { }
}

