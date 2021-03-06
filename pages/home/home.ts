import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { LoadingController } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';

import { AboutPage } from '../about/about';
import { ListPage } from '../list/list';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
	pages: Array<{ title: string, component: any }>;

  constructor(public loader: LoadingController, public navCtrl: NavController, public http: Http, private splashScreen: SplashScreen, ) {
    this.http = http;
    this.loader = loader;
    this.aqi = '';
    this.aqi = { data: {} };
    this.reload();

    this.splashScreen.show();


    this.pages = [
      { title: 'Home', component: HomePage },
      { title: 'About', component: AboutPage },
      { title: 'List', component: ListPage }
    ];
  }

  public gotoList(){
  	this.navCtrl.push(ListPage);
  }

  reload() {
    let loading = this.loader.create({
      spinner: 'dots',
      content: 'Loading',
      duration: 60000
    });
    this.http.get('http://localhost/prabhu/ionicworld/test.json')
      .toPromise()
      .then(response => {
        this.aqi = response.json();
        loading.dismiss();

      })
      .catch(error => {
        loading.dismiss();
        console.log(error.json())
        let eloading = this.loader.create({
          content: 'Connecting!',
          duration: 6000
        });
        eloading.present();
      });
  }
  aqiStatus(val) {

    if (val <= 50) {
      return { code: 'good', val: 'Good' };
    } else if (val <= 100) {
      return { code: 'mod', val: 'Moderate' };
    } else if (val <= 200) {
      return { code: 'unhealthy', val: 'Unhealthy' };
    } if (val <= 300) {
      return { code: 'vunhealthy', val: 'Very Unhealthy' };
    } else if (val > 300) {
      return { code: 'hazardous', val: 'Hazardous' };
    } else {
      return { code: '', val: '' }
    }
  }

}