function toggleForm(target) {
    const loginForm = document.getElementById('loginForm');
  
    if (target === 'login') {
      loginForm.classList.add('shrink');
    } else if (target === 'signup') {
      loginForm.classList.remove('shrink');
    }
  }
  