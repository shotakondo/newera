package exe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class CommandFactory{
	public static AbstractCommand getCommand(RequestContext rc){
		
		AbstractCommand command = null;
		Properties prop = new Properties();
		
		try{
			//�v���p�e�B�t�@�C����ǂݍ���
			prop.load(new FileInputStream("c:/webapps/teain/commands.properties"));
			
			//�p�X�ɑΉ�������������擾���܂�
			String name = prop.getProperty(rc.getCommandPath());
			
			//�w�肳�ꂽ���O�̃N���X�ɑΉ�����Class�N���X��
			//�C���X�^���X���擾����i���O�͊��S���薼�ł��邱�Ɓj
			Class c = Class.forName(name);
			
			//Class�N���X�̃C���X�^���X�𗘗p����
			//�Ή�����N���X�̃C���X�^���X�����s��
			command = (AbstractCommand) c.newInstance();
			
		}catch(FileNotFoundException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}catch(ClassNotFoundException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}catch(InstantiationException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}catch(IllegalAccessException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}
		return command;
	}
}