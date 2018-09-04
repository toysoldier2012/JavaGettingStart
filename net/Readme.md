# 04/09/2018
## ChatRoom v0.1
Basic foncion finished, connect two user with ip address and port<br>
For some tips:<br>
1. After set visible property of a window or its subclass, the windowListener may lose his efficacy
2. setText("") method can reset TextComponent. In the underlying code, 
  it requires the original text isn't null or empty to execute setText(""), 
  and the default return of getText("") method, is empty, it means
  it can't be reset if both text is null or empty, in other word, no need for resetting, 
  so excute getText("") first, to change the underlying data, and use setText("")
3. Check your ip address internet on ifconfig.me
4. For create multi-thread, must specific the program to excute in thread
