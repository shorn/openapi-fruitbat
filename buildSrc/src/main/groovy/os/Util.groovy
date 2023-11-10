package os

import org.apache.tools.ant.taskdefs.condition.Os

class Util{

  /**
   * Prefix the given command with `cmd -c` if on windows.
   * @param commands we use type `Object` instead of `String` so that it can
   * be called from Groovy cleanly (i.e. calls passing `GString` or other
   * Groovy stuff don't cause warnings in IDE tools, etc.)
   */
  static Iterable<String> osCmd(Object... commands) {
    def newCommands = []
    if( Os.isFamily(Os.FAMILY_WINDOWS) ){
      newCommands = ['cmd', '/c']
    }

    newCommands.addAll(commands)
    return newCommands
  }

}
