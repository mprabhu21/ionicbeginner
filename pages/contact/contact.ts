import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { regexValidators } from '../validators/validators';

/**
 * Generated class for the ContactPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-contact',
  templateUrl: 'contact.html',
})
export class ContactPage {
	credentialsForm: FormGroup;

  	constructor(public navCtrl: NavController, public navParams: NavParams, private formBuilder: FormBuilder) {
  		
  		this.credentialsForm = this.formBuilder.group({
	      email: [
	        '', Validators.compose([
	          Validators.pattern(regexValidators.email),
	          Validators.required
	        ])
	      ],
	      password: [
	        '', Validators.compose([
	          Validators.pattern(regexValidators.password),
	          Validators.required
	        ])
	      ]
	    });
  	}

  	onSignIn() {
	    //this.logger.info('SignInPage: onSignIn()');
	    console.log('SignInPage: onSignIn()');
	}	

  	ionViewDidLoad() {
    	console.log('ionViewDidLoad ContactPage');
  	}

}
