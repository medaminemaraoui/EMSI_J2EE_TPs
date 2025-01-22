import {Customer} from './customer.model';
import {ProductItem} from './ProductItem.model';

export interface Billing{
  id: number
  billingDate:string
  customerID: number
  customer:Customer
  quantity: number
  productItems:ProductItem[]
  totalPrice:number
}
