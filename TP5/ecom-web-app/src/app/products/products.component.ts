import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product.model';
import {ProductService} from '../services/product.service';
import {Observable} from 'rxjs';
import {Page} from '../model/page.model';

@Component({
  selector: 'app-products',
  standalone: false,

  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  // ajouter ! pour ignorer initialisation
  // ajouter $ pour dire que la variable et de type Observable
  productsNF$! : Observable<Array<Product>>;
  productsNotFiltred : any;
  page : Page;
  currentPage : number = 0;
  pageSize : number = 2 ;
  public products: Array<Product> = [];
  public keyWord: string=""
  constructor(private http:HttpClient, private productService:ProductService) {}

  ngOnInit(): void {
    this.getProduct();            // Normal
    // this.getProducts();        // Avec Type Observable
    // this.getProductsByPage();  // Normal mais sous forme des pages
    // this.getProductsByPageResponse(this.currentPage,this.pageSize);  // Normal mais sous forme des pages
  }

  getProducts(){
    this.productsNF$=this.productService.getProducts().pipe();
    console.log(" ============================ ")
    console.log(this.productsNF$)
  }

  getProduct(){
    this.productService.getProducts().subscribe({
      next : data => {
        this.productsNotFiltred = data;
        this.products = this.productsNotFiltred._embedded.products; // remove embbed and to initialize list of products directly
      },
      error : (err)=>{}
    });
  }

  getProductsByPage(currentPage:number, size:number){
    this.productService.getProductsByPage(currentPage,size).subscribe({
      next : data => {
        this.productsNotFiltred = data;
        this.products = this.productsNotFiltred._embedded.products; // remove embbed and to initialize list of products directly
      },
      error : (err)=>{}
    });
  }

  getProductsByPageResponse(currentPage:number, size:number){
    this.productService.getProductsByPageResponse(currentPage,size).subscribe({
      next : resp => {
        this.productsNotFiltred = resp.body ;
        // this.products = resp.body as Product[] ;  // il y a une erreur ????
        this.products = this.productsNotFiltred._embedded.products; // remove embbed and to initialize list of products directly
        this.page = this.productsNotFiltred.page
        console.log(this.page)
      },
      error : (err)=>{}
    });
  }

  deleteProduct(p: Product) {
    if (confirm("Est ce que vous voulez supprimer produit "+p.name+" ???? "))
    this.productService.deleteProduct(p).subscribe({
      next : data => {
        let index = this.products.indexOf(data)
        this.products.splice(index,1) ;
      },
      error : (err)=>{ }
    });
  }

  searchProducts() {
    let result= [];
    if(this.keyWord=="")
    {
      this.getProduct();
    }
    for(let p of this.products)
    {
      if(p.name.includes(this.keyWord)){
        result.push(p);
      }
    }
    this.products = result;
  }

  // searchProductsService() {
  //   this.productService.searchProducts(this.keyWord, this.currentPage, this.pageSize).subscribe(
  //     {
  //       next : value => {
  //         this.products=value;
  //       }
  //     })
  // }

  goToPage(pageNumber: number) {
    this.currentPage=pageNumber
    this.getProductsByPageResponse(this.currentPage,this.pageSize)
  }
}
