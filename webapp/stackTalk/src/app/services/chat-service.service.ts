import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SERVER_TOKEN } from '@angular/flex-layout';
import { Question } from '../model/question';
import { ResModel } from '../model/ResModel';

@Injectable({
  providedIn: 'root',
})
export class ChatServiceService {
  constructor(private httpClient: HttpClient) {}
  // apiBaseUrl = 'https://1291-122-161-50-65.in.ngrok.io/AIChat/chat';

  // // Service call
  // apiBaseUrl = 'http://localhost:8085/AIChat/chat'

//   Gateway Call
//   apiBaseUrl = 'http://localhost:8080/AIChat/chat'

  //Domain call
    apiBaseUrl = 'https://cooper.stackroute.io/AIChat/chat'

  Chat(question: Question): any {
    console.log('i was here');
    return this.httpClient.post(this.apiBaseUrl, question);
  }

  // Chat(question: Question): any {
  //   console.log('Question:', question);
  //   return this.httpClient.get('http://localhost:3000/chat');
  // }
}
