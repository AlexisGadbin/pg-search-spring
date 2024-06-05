import SwitchLanguage from '@components/switch-language.component'
import { Button } from '@components/ui/button'
import ThemeToggle from '@src/components/theme-toggle.component'
import { locales } from '@src/middleware'
import { themes } from '@src/utils/constants'
import { useTranslations } from 'next-intl'

export default function Home() {
  const t = useTranslations()

  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <h1>{t('site.title')}</h1>
      <SwitchLanguage
        options={locales.map((locale) => ({
          value: locale,
          label: t(`language.${locale}`),
        }))}
      />
      <ThemeToggle
        options={themes.map((theme) => ({
          value: theme,
          label: t(`theme.${theme}`),
        }))}
      />
      <Button>Click me</Button>
    </main>
  )
}
