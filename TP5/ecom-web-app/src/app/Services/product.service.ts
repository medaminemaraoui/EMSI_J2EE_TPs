import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  public getProductsByPageResponse(page : number=1,size : number=4){
    return this.http.get(`http://localhost:8082/products?page=${page}&size=${size}`, { observe:'response'});
  }

  public getProductsByPage(page : number=1,size : number=4): Observable<Array<Product>>{
    return this.http.get<Array<Product>>(`http://localhost:8082/products?page=${page}&size=${size}`);
  }
  public getProducts(): Observable<Array<Product>>{
    return this.http.get<Array<Product>>("http://localhost:8082/products");
  }

  public addProduct(product:Product): Observable<Product>{
    return this.http.post<Product>(`http://localhost:8082/products`,{product});
  }

  public deleteProduct(product:Product): Observable<Product>{
    return this.http.delete<Product>(`http://localhost:8082/products/${product.id}`);
  }

  // searchProducts(keyWord: string, currentPage: number, pageSize: number): Observable<Array<Product>>{
  //   return this.http.get<Array<Product>>("http://localhost:9999/INVENTORY-SERVICE/products");
  //
  // }
}
