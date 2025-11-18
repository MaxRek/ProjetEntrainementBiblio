import { HttpInterceptorFn } from '@angular/common/http';
import { AuthService } from '../service/auth-service';
import { inject } from '@angular/core';

export const jwtHeaderInterceptor: HttpInterceptorFn = (req, next) => {
  //inject authService
  /*const authService = inject(AuthService);

  console.log("Interceptor JWT HEADER\n Token = "+ authService.token);


  const authReq = req.clone({
    //header : on modifie toutes les entêtes
    //"setheaders", on en ajoute/modifie une ou plusieurs
    setHeaders: {
      'Authorization':"Bearer" + authService.token
    }
  })

  return next(authReq)*/

  const authService = inject(AuthService);

  // Pas de jeton, donc pas besoin de l'injecter ...
  if (!authService.token) {
    return next(req);
  }

  // API de connexion, donc pas besoin du jeton ...
  if (req.url.endsWith('/api/auth')) {
    return next(req);
  }

  // Dans les autres cas, on injecte le JWT
  const authReq = req.clone({
    setHeaders: {
      'Authorization': `Bearer ${ authService.token }`
    }
  });

  return next(authReq);
}
