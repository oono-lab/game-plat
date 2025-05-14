function toggleForm(target) {
    const loginForm = document.getElementById('loginForm');
    const signupForm = document.getElementById('signupForm');
    if (target === 'login') {
      loginForm.classList.add('shrink-login');
      signupForm.classList.remove('shrink-signup');
      signupForm.classList.add('second-click');
      

    } else if (target === 'signup') {
      loginForm.classList.remove('shrink-login');
      signupForm.classList.remove('second-click');
      signupForm.classList.add('shrink-signup');
    }
  }
  