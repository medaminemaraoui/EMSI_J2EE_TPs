import {Product} from './product.model';

export interface ProductItem {
  id: number
  productID: number
  price: number
  quantity: number
  product: Product
}
