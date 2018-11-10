APP.controller('EmprestimoController', function($scope, $state, $stateParams, EmprestimoService) {
  $scope.emprestimos = EmprestimoService.query();
  $scope.successMessage = $stateParams.successMessage;
});

APP.controller('EmprestimoNovoController', function($scope, $state, $stateParams, EmprestimoService, LivroService, MutuarioService) {
  $scope.emprestimo = new EmprestimoService();
  $scope.livros = LivroService.query();
  $scope.mutuarios = MutuarioService.query();

  $scope.criarEmprestimo = function() {
    $scope.emprestimo.$save(
      function() {
        $state.go('emprestimos', {'successMessage': "Emprestimo criado com sucesso!"});
      },
      function() {
        $scope.errorMessage = "Ocorreu um erro no servidor. Verifique se todos os campos foram preenchidos corretamente.";
      }
    );
  };
});

APP.controller('EmprestimoEditarController', function($scope, $state, $stateParams, EmprestimoService,LivroService,MutuarioService) {
  $scope.emprestimo = EmprestimoService.get({ id: $stateParams.id });
  $scope.livros = LivroService.query();
  $scope.mutuarios = MutuarioService.query();
  
  $scope.atualizarEmprestimo = function() {
    $scope.emprestimo.$update(function() {
        $state.go('emprestimos', {'successMessage': "Emprestimo atualizado com sucesso!"});
      }, function() {
        $scope.errorMessage = "Ocorreu um erro no servidor. Verifique se todos os campos foram preenchidos corretamente.";
      }
    );
  };
});

APP.controller('EmprestimoRemoverController', function($scope, $state, $stateParams, EmprestimoService,LivroService,MutuarioService){
	$scope.emprestimo = EmprestimoService.get({ id: $stateParams.id })  
	$scope.livros = LivroService.query();
	$scope.mutuarios = MutuarioService.query();
	  
	  $scope.deletarEmprestimo = function() {
	    $scope.emprestimo.$delete(function() {
	        $state.go('emprestimos', {'successMessage': "Emprestimo atualizado com sucesso!"});
	      }, function() {
	        $scope.errorMessage = "Ocorreu um erro no servidor. Verifique se todos os campos foram preenchidos corretamente.";
	      }
	    );
	  };
});
