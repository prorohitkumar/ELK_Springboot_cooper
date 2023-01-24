import { Component } from '@angular/core';
import { SpeechtotextService } from './services/speechtotext.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'stackTalk';

  text: string;
 
  constructor(
    public service : SpeechtotextService
  ) { 
    this.service.init()
   }
 
  ngOnInit(): void {
  }
 
  startService(){
    this.service.start()
  }
 
  stopService(){
    this.service.stop()
  }
}
