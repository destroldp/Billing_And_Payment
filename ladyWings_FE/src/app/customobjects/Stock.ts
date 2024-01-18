import { Product } from './Product';
import { Vendor } from './Vendor';

export interface Stock {
  id: number;
  productId: Product;
  costPrice: number;
  quantity: number;
  salePrice: number;
  previousSoldPrice: number;
  totalSale:number;
  productTotal: number;
  vendorDetails: Vendor;
  productName: string;
  remainingQuantity: number;
  softDelete : string;
}   