import { inject } from "@angular/core";
import { CanActivateFn, Router } from "@angular/router";
import { AuthService } from "../service/auth-service";

export const authGuard: CanActivateFn = (route, state) => {
    const router = inject(Router);
    const authService = inject(AuthService);

    if (authService.token) {
      // Ici, si on a un token, c'est qu'on est connecté
      return true;
    }
  
    return router.createUrlTree(['/login']);
}
