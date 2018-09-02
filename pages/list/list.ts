import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { HomePage } from '../home/home';
import { AboutPage } from '../about/about';
import { ListPage } from '../list/list';

/**
 * Generated class for the ListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-list',
  templateUrl: 'list.html',
})
export class ListPage {
	
	tab1Root: any = HomePage;
	tab2Root: any = AboutPage;
	tab3Root: any = ListPage;

  	constructor(public navCtrl: NavController, public navParams: NavParams) {
  		
  	}

  	goBack(){
  		this.navCtrl.pop();
  	}

  	ionViewDidLoad() {
    	console.log('ionViewDidLoad ListPage');
  	}

}
