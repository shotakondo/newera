<%@ page language="java" pageEncoding="Windows-31j" 
	 contentType="text/html; charset=Windows-31j"%>
	
<html>

	<head><title>���i�폜���</title></head>
	
	<body>
	
		<h1>���i�폜���</h1>
		
		<%-- �Ǘ��҃g�b�v�y�[�W��ʂɖ߂� --%>
		<p><a href="managertoppagejump">�@�\�Ȃ��A�Ǘ��҃g�b�v�y�[�W��ʂ�</a></p>
		
		<p><a href="logout">���O�A�E�g�@�\�A�g�b�v�y�[�W��ʂ�</a></p>
		
		<p>���i�폜�@�\�A���i�폜��ʂ�</p>
		<form method="post" action="productdelete">
			�p�����[�^�[1�F<input type="text" name="parameter1"><br>
			�p�����[�^�[2�F<input type="text" name="parameter2"><br>
			�p�����[�^�[3�F<input type="text" name="parameter3"><br>
			�p�����[�^�[4�F<input type="text" name="parameter4"><br>
			�p�����[�^�[5�F<input type="text" name="parameter5"><br>
			<input type="submit" value="�폜">
		</form>
		
	</body>
	
</html>